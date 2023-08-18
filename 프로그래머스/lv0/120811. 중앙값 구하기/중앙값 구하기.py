def solution(array):
    A = sorted(array)
    return A[int((len(array)-1)/2)]