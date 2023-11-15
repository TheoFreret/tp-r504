docker build -t im-nginx-lb .

mkdir shared1
echo "<h1>hello1</h1>" > shared1/index.html

mkdir shared2
echo "<h1>hello2</h1>" > shared2/index.html

docker run -d \
	--name nginx1 \
	-p 81:80\
	-v $(pwd)/shared1:/usr/share/nginx/html/ \
	nginx:latest

docker run -d \
	--name nginx2 \
	-p 82:80 \
	-v $(pwd)/shared2:/usr/share/nginx/html/ \
	nginx:latest

docker run -d \
	--name nginx-main \
	-p 83:80 \
 	im-nginx-lb
