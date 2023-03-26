
echo "-----------------------------------------------------------------------"
echo "===================== TEST API STUDENTS SERVICE ========================"
echo "-----------------------------------------------------------------------"

# Tạo mới user:
curl --location --request POST 'localhost:8080/api/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fullName": "NGUYEN BA THANH",
    "dateOfBirth": "29/04/1998",
    "hometown": "HA DONG, HA NOI",
    "gender": "MALE"
}' | jq

# Danh sách users:
curl --location --request GET 'localhost:8080/api/students' | jq

echo "-----------------------------------------------------------------------"
echo "===================== TEST API COURSES SERVICE ========================"
echo "-----------------------------------------------------------------------"

curl --location --request POST 'localhost:8081/api/courses/v1/createCourse' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "HOC LAM GIAU",
    "desc": "NEU MUON CO 100 ti THI PHAI THAM GIA NGAY :D",
    "author": "VNTechies"
}' | jq

# Join course:
curl --location --request POST 'localhost:8081/api/courses/v1/joinCourse' \
--header 'Content-Type: application/json' \
--data-raw '{
    "courseId": "1",
    "studentId": "1"
}' | jq

# Get detail course:
curl --location --request GET 'localhost:8081/api/courses/v1/getCourseDetailBy?courseId=1' | jq