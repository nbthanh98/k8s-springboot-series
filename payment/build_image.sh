DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo -n "Enter Image Tag, or leave blank for 'latest'"
read TAG
if [ -z $TAG ]; then
    TAG="latest"
fi

rm -rf target/

mvn clean package -Dmaven.test.skip=true

docker rmi $(docker images 'thanhnb1/payment-service' -q)

docker build -t thanhnb1/payment-service:$TAG -f $DIR/Dockerfile $DIR

docker tag thanhnb1/payment-service:latest thanhnb1/payment-service:$TAG