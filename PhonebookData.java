public class PhonebookData  implements Comparable
{
    String name;
    String mobilePhone;

    public PhonebookData(String name, String mobilePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
    }

    public String getName() {
        return name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }


    public String toString() {
        return name + " " + mobilePhone;
    }

    public static int compare(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }

        else {
            return 0;
        }
    }

    @Override
    public int compareTo(Object o) {
        PhonebookData pd = (PhonebookData)o;
        return  compare(this.name,pd.name);
    }
}