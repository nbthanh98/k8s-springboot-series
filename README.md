
## 1. Giới thiệu chung
Đây là source code cho bài viết [K8s-Springboot](https://vntechies.dev/courses/k8s-spring-boot/gioi-thieu). Có hai service:

- Student service.
- Courses service.

## 2. Chạy service với docker-compose

```shell
docker-compose -f docker/docker-compose up -d
```

## 3. Test APIs

### 1. Courses service:

```shell
# Tao moi Course:
curl --location --request POST 'localhost:8081/api/courses/v1/createCourse' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "HOC LAM GIAU",
    "desc": "NEU MUON CO 100 ti THI PHAI THAM GIA NGAY :D",
    "author": "VNTechies"
}'

# Join course:
curl --location --request POST 'localhost:8081/api/courses/v1/joinCourse' \
--header 'Content-Type: application/json' \
--data-raw '{
    "courseId": "1",
    "studentId": "1"
}'

# Get detail course:
curl --location --request GET 'localhost:8081/api/courses/v1/getCourseDetailBy?courseId=1'
```

### 2. Students service:

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
```
