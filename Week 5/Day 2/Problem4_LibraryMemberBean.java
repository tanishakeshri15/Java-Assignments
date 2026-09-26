class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {

        if (this.membershipId == null) {
            this.membershipId = membershipId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {

        if (answer == null) {
            securityAnswer = null;
        } else {
            securityAnswer = Integer.toHexString(answer.hashCode());
        }
    }
}

public class Problem4_LibraryMemberBean {

    public static void main(String[] args) {

        LibraryMember member = new LibraryMember();

        member.setMembershipId("LM101");
        member.setMembershipId("LM999");

        member.setName("Tanisha");
        member.setPremiumMember(true);

        member.setSecurityAnswer("blue");

        System.out.println("Membership ID: "
                           + member.getMembershipId());

        System.out.println("Name: "
                           + member.getName());

        System.out.println("Premium Member: "
                           + member.isPremiumMember());

        System.out.println("Security answer stored securely.");
    }
}