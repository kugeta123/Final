int main ()
{
	int j = -3;
	for (int i = 0; i < 3; i++) 
	{
	    int x = j + 2;
	    if (x == 2) j--;
	    else if (x == 0) j += 2;
	    else if (x != 3) j = 0;
	    if (j <= 0) j = 3 - i;
	}
}
