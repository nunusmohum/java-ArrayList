package com.ll.exam;

class ArrayList {
    int[] datas;
    int lastIndex = -1;

    ArrayList() {
        datas = new int[2]; // 이 부분은 수정할 수 없습니다.
    }

    public void add(int data) {
        extendSize();

        lastIndex++;

        datas[lastIndex] = data;
    }

    public void add(int data, int index) {
        extendSize();

        lastIndex++;

        for (int i = lastIndex - 1; i > index - 1; i-- ) {
            datas[i + 1] = datas[i];
        }

        datas[index] = data;

    }

    private void extendSize(){
        int beforeLength = datas.length;
        if ( lastIndex + 1 >= datas.length ) {
            // 새 버스 생성
            int[] newArr = new int[datas.length * 2];

            // 기존 버스(배열)를 버리기 전에 버스에 있던 승객들을 새 버스로 옮긴다.
            for ( int i = 0; i < datas.length; i++ ) {
                newArr[i] = datas[i];
            }

            datas = newArr;
            System.out.printf("배열의 크기가 증가되었습니다. %d => %d\n", beforeLength, datas.length);
        }
    }

    public void removeAt(int index) {
        int[] newArr = new int[datas.length-1];

        // 기존 버스(배열)를 버리기 전에 버스에 있던 승객들을 새 버스로 옮긴다.
        for ( int i = 0; i < datas.length; i++ ) {
            if(i == index){
                continue;
            }

            if(i > index){
                newArr[i-1] = datas[i];
                continue;
            }
            newArr[i] = datas[i];
        }

        datas = newArr;
        lastIndex--;
    }

    Integer get(int index) {
        return datas[index];
    }

    public int size() {
        return lastIndex + 1;
    }

    public void showAllValues(){
        System.out.println("== 전체 데이터 출력 ==");
        for(int i = 0; i < datas.length; i++){
            if(datas[i] == 0){
                continue;
            }
            System.out.printf("%d : %d\n", i, datas[i]);
        }
    }

    public int getArrayLength() {
        return datas.length;
    }
}