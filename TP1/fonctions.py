def puissance(a,b):
	if not type(a) is int:
		raise TypeError("Only integers are allowed")
	elif not type(b) is int:
		raise TypeError("Only integers are allowed")
	else :
		ab = 1
		if b>0 :
			for x in range(0,b) :
				ab = ab*a
		elif b<0 :
			b = b*-1
			for x in range(0,b) :
				ab = ab/a
		elif b==0 :
			ab = 1
		return ab

