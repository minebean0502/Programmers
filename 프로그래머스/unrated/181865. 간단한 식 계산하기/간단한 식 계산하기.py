def solution(binomial):
    A = binomial.split(' ')
    if A[1] == '+':
        return int(A[0])+int(A[2])
    elif A[1] == '-':
        return int(A[0])-int(A[2])
    else : return int(A[0])*int(A[2])