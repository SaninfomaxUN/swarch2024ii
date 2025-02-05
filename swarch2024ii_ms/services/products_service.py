from repositories.products_repository import ProductRepository


class ProductService:
    @staticmethod
    def create_product(name, description):
        return ProductRepository.create_product(name, description)

    @staticmethod
    def update_product(product_id, name, description):
        return ProductRepository.update_product(product_id, name, description)

    @staticmethod
    def get_product(product_id):
        return ProductRepository.get_product(product_id)

    @staticmethod
    def get_all_products():
        return ProductRepository.get_all_products()

    @staticmethod
    def delete_product(product_id):
        return ProductRepository.delete_product(product_id)