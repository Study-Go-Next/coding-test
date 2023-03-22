def solution(arr):
    answer = []
    answer.append(arr[0])
    for i in range(1, len(arr)):
        if arr[i] != arr[i-1]:
            answer.append(arr[i])

    return answer


def solution2(s):
    answer = []
    for i in s:
        if answer[-1:] == [i]:
            continue
        answer.append(i)

    return answer
