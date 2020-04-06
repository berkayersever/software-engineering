#include <iostream>

bool isEven(int n)
{
	return ((n % 2) == 0)
}

int factorial(int n)
{
	if(n > 1)
		return n * factorial(n - 1);
	else
		return 1;
}

int main()
{
	int n;

	cout << "Enter a positive integer: ";
	cin >> n;
	cout << "Factorial of " << n << " = " << factorial(n);

	return 0;
}
