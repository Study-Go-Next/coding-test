package lv2.기능_개발

import java.util.concurrent.ConcurrentLinkedQueue

// 접근 방식

// 작업의 속성에는 순서, 진도, 속도, 완료 여부 총 4가지로 이루어져있다고 볼 수 있다.
// 따라서 순서대로 Queue 자료 구조에 순차적으로 넣는다.
// 그리고 맨 앞 태스크가 완료 상태 일 경우 계속 다음 태스크가 완료여부인지 체크하면서 배포 리스트에 갯수를 추가한다.

fun solution(progresses: IntArray, speeds: IntArray): IntArray {

    // 1. Task 모델 정의
    // 2. Queue 생성 후 초기화
    // 3. queue 순회 하며 완료 여부 확인 및 작업 진행
    // 4. queue의 원소가 없을 경우 리턴

    val taskQueue = ConcurrentLinkedQueue<Task>().apply {
        progresses.forEachIndexed { idx, pVal ->
            this.add(
                Task(pVal = pVal, sVal = speeds[idx])
            )
        }
    }

    val result = mutableListOf<Int>()

    while(taskQueue.isNotEmpty()) {
        // 1. 작업 진행
        taskQueue.forEach(Task::run)
        // 2. 작업 완료 확인
        checkCompletedTask(taskQueue, result)
    }

    return result.toIntArray()
}

private fun checkCompletedTask(
    taskQueue: ConcurrentLinkedQueue<Task>,
    result: MutableList<Int>
) {
    val firstTask = taskQueue.peek()
    if (firstTask.isComplete()) {
        var count = 0
        for (task in taskQueue) {
            if (task.isComplete())
                taskQueue.poll().also { count++ }
            else
                break
        }
        result.add(count)
    }
}

data class Task(
    private var pVal: Int,
    private val sVal: Int,
) {
    private var isComplete = false
    fun run() {
        pVal += sVal
        if(pVal >= 100)
            isComplete = true
    }
    fun isComplete() = isComplete
}