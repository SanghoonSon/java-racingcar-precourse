package racingcar.global;

public enum ConsoleConst {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_GAME_ROUNDS("시도할 회수는 몇회인가요?"),
    ERROR_GAME_ROUNDS_NOT_NUMBERS("시도 횟수는 숫자이어야 합니다."),
    OUTPUT_GAME_REPORT("실행 결과"),
    OUTPUT_WINNERS("최종 우승자 : %s");


    private final String contents;
    ConsoleConst(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public String getContentsFormat(Object... args) {
        return String.format(contents, args);
    }
}
