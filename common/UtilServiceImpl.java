package common;

public class UtilServiceImpl implements UtilService {

    private static UtilService instance = new UtilServiceImpl();

    private UtilServiceImpl() {
    }

    public static UtilService getInstance() {
        return instance;
    }


    @Override
    public int createRandomInteger(int start, int gapBetweenStartAndEnd) {
        return start + (int) (Math.random() * gapBetweenStartAndEnd);
    }

    @Override
    public double createRandomDouble(double start, double gapBetweenStartAndEnd) {
        return Math.round(((start + Math.random() * gapBetweenStartAndEnd) * 10) / 10.0);

    }

    @Override
    public String createRandomName() {
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민",
                "정우성", "이병헌", "현 빈", "유해진", "손석구", "전도연",
                "손예진", "하지원", "김하늘", "송중기", "하정우", "장동건",
                "원 빈", "박해일", "소지섭", "김혜수"};
        return names[createRandomInteger(0, 20)];
    }

    @Override
    public String createRandomTitle() {
        String[] title = {"지방의회", "국회의원", "대통령", "국가원로자문회의",
                "국민경제", "임기연장", "국회", "제2항과 제3항", "정당", "모든 국민"};

        return title[createRandomInteger(0, 10)];

    }

    @Override
    public String createRandomContent() {
        String[] content = {
                "지방의회의 조직·권한·의원선거와 지방자치단체의 장의 선임방법 기타 지방자치단체의 조직과 운영에 관한 사항은 법률로 정한다."

                , "국회의원이 회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한 국회의 요구가 있으면 회기중 석방된다.",

                "대통령은 국가의 독립·영토의 보전·국가의 계속성과 헌법을 수호할 책무를 진다.",

                "국가원로자문회의의 의장은 직전대통령이 된다. 다만, 직전대통령이 없을 때에는 대통령이 지명한다.",

                "국민경제의 발전을 위한 중요정책의 수립에 관하여 대통령의 자문에 응하기 위하여 국민경제자문회의를 둘 수 있다.",

                "대통령의 임기연장 또는 중임변경을 위한 헌법개정은 그 헌법개정 제안 당시의 대통령에 대하여는 효력이 없다.",

                "국회는 의장 1인과 부의장 2인을 선출한다. 국무총리는 대통령을 보좌하며, 행정에 관하여 대통령의 명을 받아 행정각부를 통할한다.",

                "제2항과 제3항의 처분에 대하여는 법원에 제소할 수 없다. 모든 국민은 능력에 따라 균등하게 교육을 받을 권리를 가진다.",

                "정당은 그 목적·조직과 활동이 민주적이어야 하며, 국민의 정치적 의사형성에 참여하는데 필요한 조직을 가져야 한다.",

                "모든 국민은 보건에 관하여 국가의 보호를 받는다. 저작자·발명가·과학기술자와 예술가의 권리는 법률로써 보호한다."
        };
        return content[createRandomInteger(0, 10)];
    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글", "엔비디아", "메타", "삼성", "LG", "애플"};
        return companies[createRandomInteger(0, 6)];
    }


    @Override
    public String createRandomUsername() {
        String username = "";
        for (; username.length() < 5; username += String.valueOf((char)
                ('a' + this.createRandomInteger(0, 26)))) ;//a ->97+0=a로 한다
        return username;
    }

    @Override
    public String createRandomJob() {
        String[] job = {"백수", "회사원", "학생","교사","강사","의사","간호사"};
        return job[createRandomInteger(0,7)];
    }

}


