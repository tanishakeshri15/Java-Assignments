import java.util.Arrays;

class GymMember
{
    private int[] lateFeeHistory;
    private int feeCount;

    GymMember()
    {
        lateFeeHistory = new int[10];
        feeCount = 0;
    }

    protected void chargeLateFee(int amount)
    {
        if (feeCount < 10)
        {
            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }
    }

    public int[] getLateFeeHistory()
    {
        return Arrays.copyOf(lateFeeHistory, feeCount);
    }

    public int getTotalLateFees()
    {
        int total = 0;

        for (int i = 0; i < feeCount; i++)
        {
            total += lateFeeHistory[i];
        }

        return total;
    }
}

class PremiumMember extends GymMember
{
    @Override
    protected void chargeLateFee(int amount)
    {
        super.chargeLateFee(amount / 2);
    }
}

public class Problem3_LateFeeLedger
{
    public static void main(String[] args)
    {
        PremiumMember member = new PremiumMember();

        member.chargeLateFee(200);

        System.out.println(member.getTotalLateFees());

        int[] history = member.getLateFeeHistory();

        history[0] = 9999;

        System.out.println(Arrays.toString(member.getLateFeeHistory()));
    }
}