from flask import Blueprint, render_template, request, jsonify, redirect, url_for
from services.products_service import ProductService

product_blueprint = Blueprint('products', __name__)


@product_blueprint.route('/products', methods=['POST'])
def create_product():
    data = request.form
    name = data.get('name')
    description = data.get('description')
    if not name:
        return jsonify({'error': 'Name is required'}), 400
    ProductService.create_product(name, description)
    return redirect(url_for('products.index'))


@product_blueprint.route('/products/<int:product_id>', methods=['POST'])
def update_product(product_id):
    data = request.form
    name = data.get('name')
    description = data.get('description')
    if not name:
        return jsonify({'error': 'Name is required'}), 400
    updated_product = ProductService.update_product(product_id, name, description)
    if not updated_product:
        return jsonify({'error': 'Product not found'}), 404
    return redirect(url_for('products.index'))


@product_blueprint.route('/create', methods=['GET'])
def create_product_form():
    return render_template('create_product.html')


@product_blueprint.route('/products/<int:product_id>/edit', methods=['GET'])
def edit_product(product_id):
    product = ProductService.get_product(product_id)
    if not product:
        return jsonify({'error': 'Product not found'}), 404
    return render_template('edit_product.html', product=product)


@product_blueprint.route('/products/<int:product_id>/delete', methods=['GET'])
def delete_product(product_id):
    deleted_product = ProductService.delete_product(product_id)
    if not deleted_product:
        return jsonify({'error': 'Product not found'}), 404
    return redirect(url_for('products.index'))


@product_blueprint.route('/')
def index():
    products = ProductService.get_all_products()  # Obtener todos los productos
    return render_template('index.html', products=products)
