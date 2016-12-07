package DualSimUtils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by hexuan on 16-11-4.
 */

public class SimSubscriberId extends Base.ImplementableBase {

    private MainSimSubscriberId mainSimSubscriberId;
    private SecondSimSubscriberId secondSimSubscriberId;

    private SimSubscriberId(String model, MainSimSubscriberId mainSimSubscriberId, SecondSimSubscriberId secondSimSubscriberId) {
        super(model);
        this.mainSimSubscriberId = mainSimSubscriberId;
        this.secondSimSubscriberId = secondSimSubscriberId;
    }

    @Override
    protected void getSubscriberId(HashSet<String> set) {

        if (mainSimSubscriberId != null) {
            mainSimSubscriberId.getSubscriberId(set);
        }

        if (secondSimSubscriberId != null) {
            secondSimSubscriberId.getSubscriberId(set);
        }
    }

    @Override
    protected HashSet<String> getTmpMsg() {
        return null;
    }

    @Override
    public String toStringInternal() {
        StringBuilder builder = new StringBuilder();
        if (mainSimSubscriberId != null) {
            builder.append("MainSimSubscriberId: ").append(mainSimSubscriberId.toString()).append("\n");
        }

        if (secondSimSubscriberId != null) {
            builder.append("SecondSimSubscriberId: ").append(secondSimSubscriberId.toString()).append("\n");
        }
        return builder.toString();
    }

    public static class Builder extends BaseBuilder {

        private MainSimSubscriberId.Builder mainSimIdBuilder = new MainSimSubscriberId.Builder();
        private SecondSimSubscriberId.Builder secondSimIdBuilder = new SecondSimSubscriberId.Builder();

        @Override
        protected boolean loadSubscriberIdInternal(Context context) {
            mainSimIdBuilder.loadSubscriberId(context);
            secondSimIdBuilder.loadSubscriberId(context);
            return true;
        }

        public SimSubscriberId build() {
            return hasValue() ? new SimSubscriberId(model, mainSimIdBuilder.build(), secondSimIdBuilder.build()) : null;
        }
    }

    private static class MainSimSubscriberId extends ImplementableBase {

        public MainSimSubscriberId(String model, HashSet<String> subscriberIdSet) {
            super(model);
            tmpscriberIdSet = subscriberIdSet;
        }

        @Override
        public String toStringInternal() {
            return Arrays.toString(tmpscriberIdSet.toArray());
        }

        @Override
        protected void getSubscriberId(HashSet<String> set) {
            set.addAll(tmpscriberIdSet);
        }

        @Override
        protected HashSet<String> getTmpMsg() {
            return tmpscriberIdSet;
        }

        public static class Builder extends BaseBuilder {

            @Override
            protected boolean loadSubscriberIdInternal(Context context) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                String id = telephonyManager.getSubscriberId();
                id = (!TextUtils.isEmpty(id)) ? id : MAIN_NULL_DEVICEID;
                buildSet = new HashSet<>();
                buildSet.add(id);
                return true;
            }

            public MainSimSubscriberId build() {
                return hasValue() ? new MainSimSubscriberId(model, buildSet) : null;
            }
        }
    }

    private static class SecondSimSubscriberId extends ImplementableBase {
        private SecondSimId_1 secondSimId_1;
        private SecondSimId_2 secondSimId_2;
        private SecondSimId_3 secondSimId_3;
        private SecondSimId_4 secondSimId_4;
        private SecondSimId_5 secondSimId_5;
        private SecondSimId_6 secondSimId_6;


        public SecondSimSubscriberId(String model, SecondSimId_1 secondSimId_1, SecondSimId_2 secondSimId_2, SecondSimId_3 secondSimId_3, SecondSimId_4 secondSimId_4, SecondSimId_5 secondSimId_5, SecondSimId_6 secondSimId_6) {
            super(model);
            this.secondSimId_1 = secondSimId_1;
            this.secondSimId_2 = secondSimId_2;
            this.secondSimId_3 = secondSimId_3;
            this.secondSimId_4 = secondSimId_4;
            this.secondSimId_5 = secondSimId_5;
            this.secondSimId_6 = secondSimId_6;
        }

        @Override
        protected void getSubscriberId(HashSet<String> set) {
            if (secondSimId_1 != null) {
                set.addAll(secondSimId_1.getTmpMsg());
            }
            if (secondSimId_2 != null) {
                set.addAll(secondSimId_2.getTmpMsg());
            }
            if (secondSimId_3 != null) {
                set.addAll(secondSimId_3.getTmpMsg());
            }
            if (secondSimId_4 != null) {
                set.addAll(secondSimId_4.getTmpMsg());
            }
            if (secondSimId_5 != null) {
                set.addAll(secondSimId_5.getTmpMsg());
            }
            if (secondSimId_6 != null) {
                set.addAll(secondSimId_6.getTmpMsg());
            }
        }

        @Override
        protected HashSet<String> getTmpMsg() {
            return null;
        }

        @Override
        public String toStringInternal() {
            StringBuilder sb = new StringBuilder();
            if (secondSimId_1 != null) {
                sb.append("secondSimId_1: " + secondSimId_1.toString()).append("\n");
            }
            if (secondSimId_2 != null) {
                sb.append("secondSimId_2: " + secondSimId_2.toString()).append("\n");
            }
            if (secondSimId_3 != null) {
                sb.append("secondSimId_3: " + secondSimId_3.toString()).append("\n");
            }
            if (secondSimId_4 != null) {
                sb.append("secondSimId_4: " + secondSimId_4.toString()).append("\n");
            }
            if (secondSimId_5 != null) {
                sb.append("secondSimId_5: " + secondSimId_5.toString()).append("\n");
            }
            if (secondSimId_6 != null) {
                sb.append("secondSimId_6: " + secondSimId_6.toString()).append("\n");
            }
            return sb.toString();
        }

        public static class Builder extends BaseBuilder {
            private SecondSimId_1.Builder secondSimId_1_build = new SecondSimId_1.Builder();
            private SecondSimId_2.Builder secondSimId_2_build = new SecondSimId_2.Builder();
            private SecondSimId_3.Builder secondSimId_3_build = new SecondSimId_3.Builder();
            private SecondSimId_4.Builder secondSimId_4_build = new SecondSimId_4.Builder();
            private SecondSimId_5.Builder secondSimId_5_build = new SecondSimId_5.Builder();
            private SecondSimId_6.Builder secondSimId_6_build = new SecondSimId_6.Builder();

            @Override
            protected boolean loadSubscriberIdInternal(Context context) {
                boolean ret = secondSimId_1_build.loadSubscriberId(context) ||
                        secondSimId_2_build.loadSubscriberId(context) ||
                        secondSimId_3_build.loadSubscriberId(context) ||
                        secondSimId_4_build.loadSubscriberId(context) ||
                        secondSimId_5_build.loadSubscriberId(context) ||
                        secondSimId_6_build.loadSubscriberId(context);
                return ret;
            }

            public SecondSimSubscriberId build() {
                return hasValue() ? new SecondSimSubscriberId(model, secondSimId_1_build.build(), secondSimId_2_build.build(), secondSimId_3_build.build(), secondSimId_4_build.build(), secondSimId_5_build.build(), secondSimId_6_build.build()) : null;
            }
        }

        public static class SecondSimId_1 extends ImplementableElementBase {
            public SecondSimId_1(String model, HashSet<String> subscriberIdSet) {
                super(model);
                tmpscriberIdSet = subscriberIdSet;
            }

            @Override
            public String toStringInternal() {
                return Arrays.toString(tmpscriberIdSet.toArray());
            }

            @Override
            protected void getSubscriberId(HashSet<String> set) {
                set.addAll(tmpscriberIdSet);
            }

            @Override
            protected HashSet<String> getTmpMsg() {
                return tmpscriberIdSet;
            }

            public static class Builder extends BaseBuilder {

                @Override
                protected boolean loadSubscriberIdInternal(Context context) {
                    boolean ret = true;
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    Class<?> telephonyclass = telephonyManager.getClass();
                    Method method = null;
                    try {
                        method = telephonyclass.getDeclaredMethod("getSubscriberId", int.class);
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    }

                    if (ret) {
                        Object object = null;
                        buildSet = new HashSet<>();
                        for (int i = 0; i < 9; i++) {
                            try {
                                object = method.invoke(telephonyManager, i);
                                if (object != null) {
                                    buildSet.add(object.toString());
                                }
                            } catch (IllegalAccessException e) {
                                ret = false;
                            } catch (InvocationTargetException e2) {
                                ret = false;
                            }
                        }
                    }
                    return ret;
                }

                public SecondSimId_1 build() {
                    return hasValue() ? new SecondSimId_1(model, buildSet) : null;
                }
            }
        }

        public static class SecondSimId_2 extends ImplementableElementBase {
            public SecondSimId_2(String model, HashSet<String> subscriberIdSet) {
                super(model);
                tmpscriberIdSet = subscriberIdSet;
            }

            @Override
            protected void getSubscriberId(HashSet<String> set) {
                set.addAll(tmpscriberIdSet);
            }

            @Override
            protected HashSet<String> getTmpMsg() {
                return tmpscriberIdSet;
            }

            @Override
            public String toStringInternal() {
                return Arrays.toString(tmpscriberIdSet.toArray());
            }

            public static class Builder extends BaseBuilder {
                @Override
                protected boolean loadSubscriberIdInternal(Context context) {
                    boolean ret = true;
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    Class<?> telephonyclass = telephonyManager.getClass();
                    Method method = null;
                    try {
                        method = telephonyclass.getDeclaredMethod("getSubscriberId", long.class);
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    }

                    if (ret) {
                        Object object = null;
                        buildSet = new HashSet<>();
                        for (long i = 0; i < 9; i++) {
                            try {
                                object = method.invoke(telephonyManager, i);
                                if (object != null) {
                                    buildSet.add(object.toString());
                                }
                            } catch (IllegalAccessException e) {
                                ret = false;
                            } catch (InvocationTargetException e2) {
                                ret = false;
                            }
                        }
                    }

                    return ret;
                }

                public SecondSimId_2 build() {
                    return hasValue() ? new SecondSimId_2(model, buildSet) : null;
                }
            }
        }

        public static class SecondSimId_3 extends ImplementableElementBase {
            public SecondSimId_3(String model, HashSet<String> subscriberIdSet) {
                super(model);
                tmpscriberIdSet = subscriberIdSet;
            }

            @Override
            protected void getSubscriberId(HashSet<String> set) {
                set.addAll(tmpscriberIdSet);
            }

            @Override
            protected HashSet<String> getTmpMsg() {
                return tmpscriberIdSet;
            }

            @Override
            public String toStringInternal() {
                return Arrays.toString(tmpscriberIdSet.toArray());
            }

            public static class Builder extends BaseBuilder {
                @Override
                protected boolean loadSubscriberIdInternal(Context context) {
                    boolean ret = true;
                    Class<?> telephonyClass = null;
                    Object telephonyManager = null;
                    Method method = null;
                    try {
                        telephonyClass = Class.forName("android.telephony.MSimTelephonyManager");
                        Method getdefault = telephonyClass.getMethod("getDefault");
                        telephonyManager = getdefault.invoke(null);
                    } catch (ClassNotFoundException e) {
                        ret = false;
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    } catch (IllegalAccessException e) {
                        ret = false;
                    } catch (InvocationTargetException e) {
                        ret = false;
                    }

                    if (ret) {
                        try {
                            method = telephonyClass.getMethod("getSubscriberId", int.class);
                        } catch (NoSuchMethodException e) {
                            ret = false;
                        }
                    }

                    if (ret) {
                        Object object = null;
                        buildSet = new HashSet<>();
                        for (int i = 0; i < 9; i++) {
                            try {
                                object = method.invoke(telephonyManager, i);
                                if (object != null) {
                                    buildSet.add(object.toString());
                                }
                            } catch (IllegalAccessException e) {
                                ret = false;
                            } catch (InvocationTargetException e2) {
                                ret = false;
                            }
                        }
                    }
                    return ret;
                }

                public SecondSimId_3 build() {
                    return hasValue() ? new SecondSimId_3(model, buildSet) : null;
                }
            }
        }

        public static class SecondSimId_4 extends ImplementableElementBase {
            public SecondSimId_4(String model, HashSet<String> subscriberIdSet) {
                super(model);
                tmpscriberIdSet = subscriberIdSet;
            }

            @Override
            public String toStringInternal() {
                return Arrays.toString(tmpscriberIdSet.toArray());
            }

            @Override
            protected HashSet<String> getTmpMsg() {
                return tmpscriberIdSet;
            }

            @Override
            protected void getSubscriberId(HashSet<String> set) {
                set.addAll(tmpscriberIdSet);
            }

            public static class Builder extends BaseBuilder {
                @Override
                protected boolean loadSubscriberIdInternal(Context context) {
                    boolean ret = true;
                    Class<?> telephonyClass = null;
                    Object telephonyManager = null;
                    Method method = null;
                    try {
                        telephonyClass = Class.forName("android.telephony.MSimTelephonyManager");
                        Method getdefault = telephonyClass.getMethod("getDefault");
                        telephonyManager = getdefault.invoke(null);
                    } catch (ClassNotFoundException e) {
                        ret = false;
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    } catch (IllegalAccessException e) {
                        ret = false;
                    } catch (InvocationTargetException e) {
                        ret = false;
                    }

                    if (ret) {
                        try {
                            method = telephonyClass.getMethod("getSubscriberId", long.class);
                        } catch (NoSuchMethodException e) {
                            ret = false;
                        }
                    }

                    if (ret) {
                        Object object = null;
                        buildSet = new HashSet<>();
                        for (long i = 0; i < 9; i++) {
                            try {
                                object = method.invoke(telephonyManager, i);
                                if (object != null) {
                                    buildSet.add(object.toString());
                                }
                            } catch (IllegalAccessException e) {
                                ret = false;
                            } catch (InvocationTargetException e2) {
                                ret = false;
                            }
                        }
                    }
                    return ret;
                }

                public SecondSimId_4 build() {
                    return hasValue() ? new SecondSimId_4(model, buildSet) : null;
                }
            }
        }

        public static class SecondSimId_5 extends ImplementableElementBase {
            public SecondSimId_5(String model, HashSet<String> subscriberIdSet) {
                super(model);
                tmpscriberIdSet = subscriberIdSet;
            }

            @Override
            public String toStringInternal() {
                return Arrays.toString(tmpscriberIdSet.toArray());
            }

            @Override
            protected HashSet<String> getTmpMsg() {
                return tmpscriberIdSet;
            }

            @Override
            protected void getSubscriberId(HashSet<String> set) {
                set.addAll(tmpscriberIdSet);
            }

            public static class Builder extends BaseBuilder {
                @Override
                protected boolean loadSubscriberIdInternal(Context context) {
                    boolean ret = true;
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone2");
                        String id = telephonyManager.getSubscriberId() != null ? telephonyManager.getSubscriberId() : "Nothing";
                        buildSet = new HashSet<>();
                        buildSet.add(id);
                    } catch (NullPointerException e) {
                        ret = false;
                    }
                    return ret;
                }

                public SecondSimId_5 build() {
                    return hasValue() ? new SecondSimId_5(model, buildSet) : null;
                }
            }
        }

        public static class SecondSimId_6 extends ImplementableElementBase {
            public SecondSimId_6(String model, HashSet<String> subscriberIdSet) {
                super(model);
                tmpscriberIdSet = subscriberIdSet;
            }

            @Override
            public String toStringInternal() {
                return Arrays.toString(tmpscriberIdSet.toArray());
            }

            @Override
            protected HashSet<String> getTmpMsg() {
                return tmpscriberIdSet;
            }

            @Override
            protected void getSubscriberId(HashSet<String> set) {
                set.addAll(tmpscriberIdSet);
            }

            public static class Builder extends BaseBuilder {
                @Override
                protected boolean loadSubscriberIdInternal(Context context) {
                    boolean ret = true;
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    Class<?> telephonyclass = telephonyManager.getClass();
                    Method method = null;
                    try {
                        method = telephonyclass.getDeclaredMethod("getSubscriberIdGemini", int.class);
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    }

                    if (ret) {
                        Object object = null;
                        buildSet = new HashSet<>();
                        for (int i = 0; i < 9; i++) {
                            try {
                                object = method.invoke(telephonyManager, i);
                                if (object != null) {
                                    buildSet.add(object.toString());
                                }
                            } catch (IllegalAccessException e) {
                                ret = false;
                            } catch (InvocationTargetException e2) {
                                ret = false;
                            }

                            ret = !buildSet.isEmpty();
                        }
                    }
                    return ret;
                }

                public SecondSimId_6 build() {
                    return hasValue() ? new SecondSimId_6(model, buildSet) : null;
                }
            }

        }
    }
}


