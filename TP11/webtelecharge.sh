#!/bin/bash

if [ -e $1 ]
then
	echo "deja telecharger"
else
	wget http://xkcd.com/$1
fi

IFS=":"; sed '19q;d' 2862
echo $a