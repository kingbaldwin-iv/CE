// There exist N vertices in a graph and every possible edge is included with the probability P. 
// compute the expected number of triangles and variance

#include <stdio.h>
#define N 10
#define P 0.3
double fact(int n) {
  long u = 1;
  for (long i = 1; i <= n; i++)
    u *= i;
  return u;
}
double pow(double, double);
double binom(int n, int k) { return fact(n) / (fact(n - k) * fact(k)); }
int main(void) {
  double expected_value = binom(N, 3) * pow(P, 3);
  double varianz =
      binom(N, 3) * pow(P, 3) + binom(N, 2) * (N - 2) * (N - 3) * pow(P, 5) +
      N * binom(N - 1, 2) * binom(N - 3, 2) * pow(P, 6) +
      binom(N, 3) * binom(N - 3, 3) * pow(P, 6) - pow(expected_value, 2);
  printf("expected value = %.6f, varianz =  %.6f", expected_value, varianz);
}
