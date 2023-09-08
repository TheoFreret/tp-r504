import pytest
import fonctions as f

def test_1():
	assert f.puissance(2,3) == 8
	assert f.puissance(2,2) == 4

def test_2():
	assert f.puissance(-1,2) == 1
	assert f.puissance(2,-1) == 0.5

def test_3():
	assert f.puissance(2,8) == 16
	assert f.puissance(-3,2) == 9
