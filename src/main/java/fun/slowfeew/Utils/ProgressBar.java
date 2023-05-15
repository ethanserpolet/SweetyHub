package fun.slowfeew.Utils;

import com.google.common.base.Strings;
import org.bukkit.ChatColor;

public class ProgressBar {

    public static String getProgressBar(Double current, int max, int totalBars, char symbol, ChatColor completedColor, ChatColor notCompletedColor) {
        if(current > max || current < 0 || max <= 0 || totalBars <= 0) {
            System.out.println(max);
            System.out.println(current);
            System.out.println(totalBars);
            throw new IllegalArgumentException("Invalid parameters");
        }

        Double percent = current / max;
        int progressBars = (int) Math.round(totalBars * percent);

        StringBuilder progressBar = new StringBuilder(totalBars);

        // Apply color once, then repeat symbol
        progressBar.append(completedColor);
        progressBar.append(Strings.repeat("" + symbol, progressBars));
        progressBar.append(notCompletedColor);
        progressBar.append(Strings.repeat("" + symbol, totalBars - progressBars));

        return progressBar.toString();

    }


}
