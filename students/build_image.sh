SERVICE_NAME="students-service"
IMAGE_REGISTRY="thanhnb1"
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo -n "Enter Image Tag, or leave blank for 'latest'"
read TAG
if [ -z $TAG ]; then
    TAG="latest"
fi

rm -rf target/

mvn clean package -Dmaven.test.skip=true

docker rmi $(docker images '$IMAGE_REGISTRY/$SERVICE_NAME' -q)

docker build -t $IMAGE_REGISTRY/$SERVICE_NAME:$TAG -f $DIR/Dockerfile $DIR

docker tag $IMAGE_REGISTRY/$SERVICE_NAME:latest $IMAGE_REGISTRY/$SERVICE_NAME:$TAG