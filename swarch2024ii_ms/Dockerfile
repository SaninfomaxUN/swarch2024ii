FROM python

LABEL authors="S4N"

WORKDIR /app

COPY requirements.txt requirements.txt

RUN pip install -r requirements.txt

COPY . .

EXPOSE 4000

CMD ["python", "app.py"]