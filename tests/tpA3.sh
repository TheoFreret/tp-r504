if [ "$1" == "" ]
then
	n1=5
else
	n1=$1
fi

if [ "$2" == "" ]
then
	n2=$((n1 + 10))
else
	n2=$2
fi

for (( c=$n1; c<=$n2; c++ ))
do
	echo -n "$c "
done
echo
