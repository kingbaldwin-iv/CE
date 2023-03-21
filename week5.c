#include <stdio.h>
long bitcount(long v) {
  long c;
  c = v - ((v >> 1) & 0x55555555);
  c = ((c >> 2) & 0x33333333) + (c & 0x33333333);
  c = ((c >> 4) + c) & 0x0F0F0F0F;
  c = ((c >> 8) + c) & 0x00FF00FF;
  c = ((c >> 16) + c) & 0x0000FFFF;
  return c;
}
long gcd(long i, long i2) { return (i2 == 0) ? i : gcd(i2, i % i2); }
long lcmA(long i, long i2) { return i * i2 / gcd(i, i2); }
int main() {
  int divisors[] = {2, 43, 79, 31, 53};
  int length = (int)(sizeof(divisors) / sizeof(divisors[0]));
  long s = 0, lcm = 1, powerset = 1 << length;
  for (int i = 1; i < powerset; i++) {
    lcm = 1;
    for (int j = 0; j < length; j++) {
      if ((i & (1 << j)) > 0)
        lcm = lcmA(lcm, divisors[j]);
    }
    if (bitcount(i) % 2 == 1)
      s += (10000000000L / lcm);
    else
      s -= (10000000000L / lcm);
  }
  printf("%ld", 10000000000L - s);
}
