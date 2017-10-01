FROM openjdk:8-jre-alpine
MAINTAINER jovi.mao

#更新
RUN apk update

#安装字体库
RUN apk add --no-cache ttf-dejavu

#修改时区
RUN apk add --no-cache ca-certificates && \
	apk add --no-cache tzdata && \
	ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
	echo "Asia/Shanghai" > /etc/timezone

COPY target/zhabei-client-1.0-SNAPSHOT.jar /app.jar

RUN chmod +x /app.jar


CMD java -jar /app.jar