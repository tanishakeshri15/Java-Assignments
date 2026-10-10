class GymMember
{
    private static int membersEnrolled = 0;

    public final String membershipNumber;

    private int feesPaid;

    public GymMember(int monthlyFee)
    {
        if (monthlyFee <= 0)
        {
            throw new IllegalArgumentException("Monthly fee must be positive");
        }

        membersEnrolled++;
        membershipNumber = "GYM-" + (2000 + membersEnrolled);

        feesPaid = 0;
    }

    public void payFee(int amount)
    {
        if (amount > 0)
        {
            feesPaid += amount;
        }
    }

    public void payFee(int amount, String mode)
    {
        payFee(amount);
    }

    public int getFeesPaid()
    {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code)
    {
        if (code == null || code.length() != 4)
        {
            return false;
        }

        if (code.charAt(0) != 'G')
        {
            return false;
        }

        if (!Character.isDigit(code.charAt(1)))
        {
            return false;
        }

        if (!Character.isDigit(code.charAt(2)))
        {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3)))
        {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled()
    {
        return membersEnrolled;
    }
}

class GroupClassMember extends GymMember
{
    private String className;

    public GroupClassMember(int monthlyFee, String className)
    {
        super(monthlyFee);
        this.className = className;
    }
}

public class Problem5_WeeklyCheckIn
{
    public static String processWeeklyCheckIn(GymMember[] members)
    {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members)
        {
            if (member == null)
            {
                nullSkipped++;
            }
            else
            {
                processed++;

                if (member instanceof GroupClassMember)
                {
                    group++;
                }
                else
                {
                    individual++;
                }
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args)
    {
        GymMember m1 = new GymMember(1000);

        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(GymMember.isValidReferralCode("G12A"));
        System.out.println(GymMember.isValidReferralCode("G1A2"));
        System.out.println(GymMember.isValidReferralCode("X12A"));

        m1.payFee(1000, "UPI");
        System.out.println(m1.getFeesPaid());

        GroupClassMember m2 =
                new GroupClassMember(1500, "Zumba");

        GymMember[] members = {m1, null, m2};

        System.out.println(
            processWeeklyCheckIn(members)
        );
    }
}