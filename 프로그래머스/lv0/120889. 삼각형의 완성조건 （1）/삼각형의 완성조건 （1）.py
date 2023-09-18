def solution(sides):
    A = sorted(sides)
    if A[-1] < A[0]+A[1]:
        return 1
    else : return 2