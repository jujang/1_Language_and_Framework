students = ["egoing", "sori", "maru"]
grades = [2, 1, 6]
print("students[1]", students[1])
print("len(students)", len(students))
print(min(grades))
print(max(grades))

import statistics #통계와 관련된 것을 사용하기 위한 모듈
print("statistics.mean(grades)", statistics.mean(grades))

import random
print(random.choice(students))