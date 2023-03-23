#include <stdio.h>
float sum(int a[], int l) {
  float s = 0;
  for (int i = 0; i < l; i++)
    s += a[i];
  return s;
}
void q1(int a[], int l) {
  float s = sum(a, l);
  printf("%5.5f \n", 1.0 - a[0] * a[0] / s / s);
}
float q2(int a[], int e, int l) {
  float s = sum(a, l), z = a[0] * a[0] / s / s;
  for (int i = 1; i < l; i++)
    z += a[i] / s * a[0] / (s - a[i]);
  if (e == 1)
    printf("%5.5f \n", z);
  return z;
}
void q3(int a[], int l) {
  float s = sum(a, l);
  printf("%5.5f \n", a[0] / (s - a[1]) * a[1] / s / q2(a, 0, l));
}
int main(void) {
  int i[] = {6, 16, 9, 6,  19, 18, 13, 9, 12, 19,
             9, 17, 9, 20, 11, 19, 12, 9, 5,  18};
  int l = (int)(sizeof(i) / sizeof(int));
  q1(i, l);
  q2(i, 1, l);
  q3(i, l);
}
