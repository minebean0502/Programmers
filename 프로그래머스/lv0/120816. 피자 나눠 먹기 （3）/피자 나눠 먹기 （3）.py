def solution(slice, n):
    i = 1
    while True:
        if (slice*i)/n >= 1:
            return i
        elif slice/n < 1:
            i +=1