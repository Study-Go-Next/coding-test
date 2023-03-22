def solution(progresses, speeds):
    answer = []
    cnt = 0

    while cnt < len(progresses):
        print(answer)
        for i in range(len(progresses)):
            progresses[i] += speeds[i]

        num_deploy = 0
        while cnt < len(progresses) and progresses[cnt] >= 100:
            num_deploy += 1
            cnt += 1

        if num_deploy > 0:
            answer.append(num_deploy)
    return answer


def solution2(progresses, speeds):
    answer = []

    while len(progresses) > 0:
        print(answer)
        for i in range(len(progresses)):
            progresses[i] += speeds[i]

        num_deploy = 0
        while len(progresses) > 0:
            if progresses[0] >= 100:
                progresses.pop(0)
                speeds.pop(0)
                num_deploy += 1
            else:
                break

        if num_deploy > 0:
            answer.append(num_deploy)

    return answer
