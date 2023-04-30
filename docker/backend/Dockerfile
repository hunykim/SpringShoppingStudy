FROM adoptopenjdk/openjdk11

RUN mkdir -p jar

WORKDIR /jar

COPY ../../build/libs/shop-study-0.0.1-SNAPSHOT.jar boot.jar

#ENTRYPOINT ["java", "-jar","/jar/boot.jar"]
# CMD ["java", "-jar","/jar/boot.jar"]

# 이미지 생성 명령어 (현 파일과 같은 디렉토리에서)
# docker build -t {이미지명} .

# 컨테이너 생성 & 실행 명령어
# docker run --name {컨테이너명} -v $(pwd):/usr/src/app -p 8080:8080 {이미지명}