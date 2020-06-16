package validIpAddress;

public class CheckValidIP {
    public String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty()) return "Neither";
        if (IP.contains(".") && isValidIpv4(IP)) return "IPv4";
        if (IP.contains(":") && isValidIpv6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean isValidIpv4(String IP) {
        String[] groups = IP.split("\\.", -1);
        if (groups.length != 4) return false;

        for (String group : groups) {
            if (group.isEmpty() || (group.charAt(0) == '0' && group.length() > 1) || group.charAt(0) == '-')
                return false;

            try {
                int num = Integer.parseInt(group);
                if (num < 0 || num > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidIpv6(String IP) {
        String[] groups = IP.split(":", -1);
        if (groups.length != 8) return false;

        for (String group : groups) {
            if (group.isEmpty() || group.length() > 4 || group.charAt(0) == '-')
                return false;

            try {
                Long.parseLong(group, 16);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
