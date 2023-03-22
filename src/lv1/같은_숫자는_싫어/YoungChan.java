package lv1.같은_숫자는_싫어;

import java.util.*;

public class YoungChan {

    // 접근 방식
    // 원래의 순서를 유지해야 하기 때문에 FIFO 자료 구조인 큐를 이용한다.
    // 항상 큐의 마지막 원소값으로 비교하면 해결 할 수 있다.

    public int[] solution(int []arr) {

        // 1. Queue 생성
        // 2. arr 배열을 순회하며 테일 값 비교
        // 3. 큐의 값들을 꺼내 배열로 가공한 후 리턴

        final LinkedList<Integer> queue = new LinkedList<>();

        Arrays
            .stream(arr)
            .forEach(i ->
                Optional
                    .ofNullable(queue.peekLast())
                    .ifPresentOrElse(
                        last -> {
                            if(last != i)
                                queue.add(i);
                        },
                        () -> queue.add(i)
                    )
            );

        return queue
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
