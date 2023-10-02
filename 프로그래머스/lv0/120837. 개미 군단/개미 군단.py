def solution(hp):
    a,b,c = hp // 5, hp%5 // 3, (hp%5)%3 // 1
    return a+b+c