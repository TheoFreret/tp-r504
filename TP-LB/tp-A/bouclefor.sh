set +x
count1=0
count2=0
for i in {1..500..1}
do
#	curl http://localhost:83
#	curl http://localhost:83 1> curl.txt 2>/dev/null
	a=$(curl http://localhost:83 2>/dev/null)
#	echo "a=$a"
	if [ "$a" = '<h1>hello1</h1>' ]
	then
		((count1++))
	else
		((count2++))
	fi
done
echo "c1=$count1"
echo "c2=$count2"