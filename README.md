
## 1. Giới thiệu chung
Đây là source code cho bài viết [K8s-Springboot](https://vntechies.dev/courses/k8s-spring-boot/gioi-thieu). Có hai service:

- Student service.
- Payment service.

## 2. Chạy service với docker-compose

```shell
docker-compose -f docker/docker-compose up -d
```

## 3. Test APIs

1. Payment service:
```shell
curl --location --request GET 'localhost:8081/api/payment/v1/getAllBill'
```
2. Students service:

```shell

# Tạo mới user:
curl --location --request POST 'localhost:8080/api/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fullName": "NGUYEN BA THANH",
    "dateOfBirth": "29/04/1998",
    "hometown": "HA DONG, HA NOI",
    "gender": "MALE"
}'

# Danh sách users:
curl --location --request GET 'localhost:8080/api/students'

# PayBill:
curl --location --request POST 'localhost:8080/api/payment/payBill' \
--header 'Content-Type: application/json' \
--data-raw '{
    "billId": "0cf6b569-f610-408a-a033-76e16ecbeffe",
    "studentId": "8a4a6d12-dae8-4589-a0b3-a72d9fe48e4c",
    "amount": 10000000,
    "fromAccountNo": "123456789",
    "toAccountNo": "123456789",
    "transDesc": "THANH TOAN HOA DON"
}'
```
