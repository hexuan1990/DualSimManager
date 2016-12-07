package DualSimUtils;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by hexuan on 16-11-4.
 */

public class SimManagerWrapper extends Base.ImplementableBase{
    private final static String TAG = SimManagerWrapper.class.getSimpleName();
    private static WeakReference<SimManagerWrapper> instance;
    private SimSubscriberId simSubscriberId;

    public static  SimManagerWrapper getInstance(Context context) {
        SimManagerWrapper wrapper = (instance == null) ? null : instance.get();
        if (wrapper == null) {
            synchronized (SimManagerWrapper.class) {
                wrapper = Builder.getInstance(context).build();
                instance = new WeakReference<SimManagerWrapper>(wrapper);
            }
        }
        return wrapper;
    }

    public static void clear() {
        if (instance != null) {
            instance.clear();
            instance = null;
        }
    }

    public SimManagerWrapper(String string, SimSubscriberId simSubscriberId) {
        super(string);
        this.simSubscriberId = simSubscriberId;
    }

    @Override
    protected HashSet<String> getTmpMsg() {
        return null;
    }

    private String[] getEntireIMSI() {
        HashSet<String> result = new HashSet<>();
        getSubscriberId(result);
        String[] strings = new String[result.size()];
        result.toArray(strings);
        for (int i = 0; i< strings.length;i++) {
            strings[i] = strings[i].toString().equals(MAIN_NULL_DEVICEID) ? NULL_DEVICEID : strings[i].toString();
        }
        Arrays.sort(strings);
        return strings;
    }

    public static  boolean checkIsMultiSim(Context context) {
        boolean ret = false;
        try {
            ret = isMultiSimEnabledInternal(context) || isMultiSimEnabledInternal_2();
        }catch (InvocationTargetException e) {
            ret = false;
        }catch (IllegalAccessException e){
            ret = false;
        }catch (ClassNotFoundException e){
            ret = false;
        }catch (NoSuchMethodException e){
            ret = false;
        }catch (NullPointerException e){
            ret = false;
        }
        Log.d(TAG,"SimManagerWrapper checkisMultiSim is " + ret);
        return ret;
    }

    private static boolean isMultiSimEnabledInternal(Context context)throws IllegalAccessException,InvocationTargetException,ClassNotFoundException,NoSuchMethodException {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        Class<?> telephonyClass = TelephonyManager.class;
        Method getSubscriberId = telephonyClass.getMethod("isMultiSimEnabled");
        Object ret  = getSubscriberId.invoke(telephonyManager);
        return (boolean)ret;
    }

    private static boolean isMultiSimEnabledInternal_2()throws IllegalAccessException,InvocationTargetException,ClassNotFoundException,NoSuchMethodException {
        Class<?> telephonyClass = Class.forName("android.telephony.MSimTelephonyManager");
        Method getDefault = telephonyClass.getMethod("getDefault");
        Object telephonyManager  = getDefault.invoke(null);
        Method method = telephonyClass.getMethod("isMultiSimEnabled");
        Object ret  = method.invoke(telephonyManager);
        return (boolean)ret;
    }

    public final String getSecondIMSI() {
        String[] ids = getEntireIMSI();
        return ids.length > 1 ? ids[1] : "";
    }

    public final String getMainIMSI() {
        String[] ids = getEntireIMSI();
        return ids[0];
    }

    @Override
    protected void getSubscriberId(HashSet<String> set) {
        simSubscriberId.getSubscriberId(set);
    }

    @Override
    public String toStringInternal() {
        StringBuilder builder = new StringBuilder();
        if (simSubscriberId != null) {
            builder.append("SimSubscriberId: " + simSubscriberId.toString()).append("\n");
        }
        return builder.toString();
    }

    private static class Builder extends BaseBuilder {
        private SimSubscriberId.Builder builder = new SimSubscriberId.Builder();
        private static Builder instance;

        public static Builder getInstance(Context context) {
            synchronized (Builder.class) {
                if (instance == null) {
                    instance = new Builder().init(context);
                }
            }
            return instance;
        }

        public Builder init(Context context) {
            model = Build.MODEL;
            loadSubscriberId(context);
            return this;
        }

        @Override
        protected boolean loadSubscriberIdInternal(Context context) {
            return builder.loadSubscriberId(context);
        }

        public SimManagerWrapper build() {
            return hasValue() ? new SimManagerWrapper(model, builder.build()) : null;
        }
    }

}
