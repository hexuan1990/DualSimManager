package DualSimUtils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by hexuan on 17-1-4.
 */

public class SimCardID extends SimBase.ImplementableBase {
    public MainSimCard mainSimSubscriberId;
    public SecondSimCardID secondSimSubscriberId;

    public SimCardID(MainSimCard mainSimSubscriberId, SecondSimCardID secondSimSubscriberId) {
        super();
        this.mainSimSubscriberId = mainSimSubscriberId;
        this.secondSimSubscriberId = secondSimSubscriberId;
    }

    @Override
    protected void getAllEntrieIMSI(Set<String> result) {
        if (mainSimSubscriberId != null) {
            mainSimSubscriberId.getAllEntrieIMSI(result);
        }

        if (secondSimSubscriberId != null) {
            secondSimSubscriberId.getAllEntrieIMSI(result);
        }
    }

    @Override
    public String toStringInternal() {
        StringBuilder builder = new StringBuilder();
        if (mainSimSubscriberId != null) {
            builder.append("MainSimSubscriberId: " + mainSimSubscriberId.toString()).append("\n");
        }

        if (secondSimSubscriberId != null) {
            builder.append("SecondSimSubscriberId: " + secondSimSubscriberId.toString()).append("\n");
        }
        return builder.toString();
    }

    public static class Builder extends SimBase.BaseBuilder {
        private MainSimCard.Builder mainSimIdBuilder = new MainSimCard.Builder();
        private SecondSimCardID.Builder secondSimIdBuilder = new SecondSimCardID.Builder();

        @Override
        protected boolean isSupportedReflectInternal(Context context) {
            mainSimIdBuilder.isSupportedReflect(context);
            secondSimIdBuilder.isSupportedReflect(context);
            return true;
        }

        public SimCardID build() {
            return isSupported() ? new SimCardID(mainSimIdBuilder.build(), secondSimIdBuilder.build()) : null;
        }
    }

    public static class MainSimCard extends SimBase.ImplementableBase {
        Context context;
        public MainSimCard(Context context) {
            super();
            this.context = context;
        }

        @Override
        protected String toStringInternal() {
            return getClass().getSimpleName();
        }

        @Override
        protected void getAllEntrieIMSI(Set<String> result) {
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
            String id = telephonyManager.getSubscriberId();
            result.add(id);
        }

        public static class Builder extends SimBase.BaseBuilder {
            Context context;
            @Override
            protected boolean isSupportedReflectInternal(Context context) {
                this.context = context;
                return true;
            }

            public MainSimCard build() {
                return isSupported() ? new MainSimCard(context) : null;
            }
        }
    }

    public static class SecondSimCardID extends SimBase.ImplementableBase {
        private SecondSimCardID_1 secondSimId_1;
        private SecondSimCardID_2 secondSimId_2;
        private SecondSimCardID_3 secondSimId_3;
        private SecondSimCardID_4 secondSimId_4;
        private SecondSimCardID_5 secondSimId_5;
        private SecondSimCardID_6 secondSimId_6;

        public SecondSimCardID(SecondSimCardID_1 secondSimId_1, SecondSimCardID_2 secondSimId_2,SecondSimCardID_3 secondSimId_3, SecondSimCardID_4 secondSimId_4, SecondSimCardID_5 secondSimId_5, SecondSimCardID_6 secondSimId_6) {
            super();
            this.secondSimId_1 = secondSimId_1;
            this.secondSimId_2 = secondSimId_2;
            this.secondSimId_3 = secondSimId_3;
            this.secondSimId_4 = secondSimId_4;
            this.secondSimId_5 = secondSimId_5;
            this.secondSimId_6 = secondSimId_6;
        }

        @Override
        protected void getAllEntrieIMSI(Set<String> result) {
            if (secondSimId_1 != null) {
                secondSimId_1.getAllEntrieIMSI(result);
            }
            if (secondSimId_2 != null) {
                secondSimId_2.getAllEntrieIMSI(result);
            }
            if (secondSimId_3 != null) {
                secondSimId_3.getAllEntrieIMSI(result);
            }
            if (secondSimId_4 != null) {
                secondSimId_4.getAllEntrieIMSI(result);
            }
            if (secondSimId_5 != null) {
                secondSimId_5.getAllEntrieIMSI(result);
            }
            if (secondSimId_6 != null) {
                secondSimId_6.getAllEntrieIMSI(result);
            }
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
        public static class Builder extends SimBase.BaseBuilder {
            private SecondSimCardID_1.Builder secondSimId_1_build = new SecondSimCardID_1.Builder();
            private SecondSimCardID_2.Builder secondSimId_2_build = new SecondSimCardID_2.Builder();
            private SecondSimCardID_3.Builder secondSimId_3_build = new SecondSimCardID_3.Builder();
            private SecondSimCardID_4.Builder secondSimId_4_build = new SecondSimCardID_4.Builder();
            private SecondSimCardID_5.Builder secondSimId_5_build = new SecondSimCardID_5.Builder();
            private SecondSimCardID_6.Builder secondSimId_6_build = new SecondSimCardID_6.Builder();

            @Override
            protected boolean isSupportedReflectInternal(Context context) {
                boolean ret = secondSimId_1_build.isSupportedReflect(context) ||
                        secondSimId_2_build.isSupportedReflect(context) ||
                        secondSimId_3_build.isSupportedReflect(context) ||
                        secondSimId_4_build.isSupportedReflect(context) ||
                        secondSimId_5_build.isSupportedReflect(context) ||
                        secondSimId_6_build.isSupportedReflect(context);
                return ret;
            }

            public SecondSimCardID build() {
                return isSupported() ? new SecondSimCardID(secondSimId_1_build.build() ,secondSimId_2_build.build(),secondSimId_3_build.build(), secondSimId_4_build.build(), secondSimId_5_build.build(), secondSimId_6_build.build()) : null;
            }
        }

        public static class SecondSimCardID_1 extends SimBase.ImplementableBase {
            Method method;
            Object receiver;

            public SecondSimCardID_1(Method method, Object receiver) {
                super();
                this.method = method;
                this.receiver = receiver;
            }

            @Override
            protected String toStringInternal() {
                return getClass().getSimpleName();
            }

            @Override
            protected void getAllEntrieIMSI(Set<String> result) {
                Object object = null;
                for (int i = 0; i < 9; i++) {
                    try {
                        object = method.invoke(receiver, i);
                        if (object != null && !TextUtils.isEmpty(object.toString())) {
                            result.add(object.toString());
                        }
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e2) {
                    }
                }
            }


            public static class Builder extends SimBase.BaseBuilder {
                Method method = null;
                Object receiver = null;

                @Override
                protected boolean isSupportedReflectInternal(Context context) {
                    boolean ret = true;
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    Class<?> telephonyclass = telephonyManager.getClass();

                    try {
                        method = telephonyclass.getDeclaredMethod("getSubscriberId", int.class);
                        receiver = telephonyManager;
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    }
                    return ret;
                }

                public SecondSimCardID_1 build() {
                    return isSupported() ? new SecondSimCardID_1(method, receiver) : null;
                }
            }
        }


        public static class SecondSimCardID_2 extends SimBase.ImplementableBase {
            Method method;
            Object receiver;

            public SecondSimCardID_2(Method method, Object receiver) {
                super();
                this.method = method;
                this.receiver = receiver;
            }

            @Override
            protected String toStringInternal() {
                return getClass().getSimpleName();
            }

            @Override
            protected void getAllEntrieIMSI(Set<String> result) {
                Object object = null;
                for (long i = 0; i < 9; i++) {
                    try {
                        object = method.invoke(receiver, i);
                        if (object != null && !TextUtils.isEmpty(object.toString())) {
                            result.add(object.toString());
                        }
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e2) {
                    }
                }
            }


            public static class Builder extends SimBase.BaseBuilder {
                Method method = null;
                Object receiver = null;

                @Override
                protected boolean isSupportedReflectInternal(Context context) {
                    boolean ret = true;
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    Class<?> telephonyclass = telephonyManager.getClass();
                    try {
                        method = telephonyclass.getDeclaredMethod("getSubscriberId", long.class);
                        receiver = telephonyManager;
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    }
                    return ret;
                }

                public SecondSimCardID_2 build() {
                    return isSupported() ? new SecondSimCardID_2(method, receiver) : null;
                }
            }
        }

        public static class SecondSimCardID_3 extends SimBase.ImplementableBase {
            Method method;
            Object receiver;

            public SecondSimCardID_3(Method method, Object receiver) {
                super();
                this.method = method;
                this.receiver = receiver;
            }

            @Override
            protected String toStringInternal() {
                return getClass().getSimpleName();
            }

            @Override
            protected void getAllEntrieIMSI(Set<String> result) {
                Object object = null;
                for (int i = 0; i < 9; i++) {
                    try {
                        object = method.invoke(receiver, i);
                        if (object != null && !TextUtils.isEmpty(object.toString())) {
                            result.add(object.toString());
                        }
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e2) {
                    }
                }
            }


            public static class Builder extends SimBase.BaseBuilder {
                Method method = null;
                Object receiver = null;

                @Override
                protected boolean isSupportedReflectInternal(Context context) {
                    boolean ret = true;
                    Class<?> telephonyClass = null;
                    try {
                        telephonyClass = Class.forName("android.telephony.MSimTelephonyManager");
                        Method getDefault = telephonyClass.getMethod("getDefault");
                        receiver = getDefault.invoke(null);
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
                    return ret;
                }

                public SecondSimCardID_3 build() {
                    return isSupported() ? new SecondSimCardID_3(method, receiver) : null;
                }

            }
        }

        public static class SecondSimCardID_4 extends SimBase.ImplementableBase {
            Method method;
            Object receiver;

            public SecondSimCardID_4(Method method, Object receiver) {
                super();
                this.method = method;
                this.receiver = receiver;
            }

            @Override
            protected String toStringInternal() {
                return getClass().getSimpleName();
            }

            @Override
            protected void getAllEntrieIMSI(Set<String> result) {
                Object object = null;
                for (long i = 0; i < 9; i++) {
                    try {
                        object = method.invoke(receiver, i);
                        if (object != null && !TextUtils.isEmpty(object.toString())) {
                            result.add(object.toString());
                        }
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e2) {
                    }
                }
            }


            public static class Builder extends SimBase.BaseBuilder {
                Method method = null;
                Object receiver = null;

                @Override
                protected boolean isSupportedReflectInternal(Context context) {
                    boolean ret = true;
                    Class<?> telephonyClass = null;
                    try {
                        telephonyClass = Class.forName("android.telephony.MSimTelephonyManager");
                        Method getDefault = telephonyClass.getMethod("getDefault");
                        receiver = getDefault.invoke(null);
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
                    return ret;
                }

                public SecondSimCardID_4 build() {
                    return isSupported() ? new SecondSimCardID_4(method, receiver) : null;
                }

            }
        }

        public static class SecondSimCardID_5 extends SimBase.ImplementableBase {
            TelephonyManager telephonyManager;

            public SecondSimCardID_5(TelephonyManager telephonyManager) {
                super();
                this.telephonyManager = telephonyManager;
            }

            @Override
            protected String toStringInternal() {
                return getClass().getSimpleName();
            }

            @Override
            protected void getAllEntrieIMSI(Set<String> result) {
                result.add(telephonyManager.getSubscriberId());
            }


            public static class Builder extends SimBase.BaseBuilder {
                TelephonyManager telephonyManager;

                @Override
                protected boolean isSupportedReflectInternal(Context context) {
                    boolean ret = true;
                    try {
                        telephonyManager = (TelephonyManager) context.getSystemService("phone2");
                        String id = telephonyManager.getSubscriberId();
                    } catch (NullPointerException e) {
                        ret = false;
                    }
                    return ret;
                }

                public SecondSimCardID_5 build() {
                    return isSupported() ? new SecondSimCardID_5(telephonyManager) : null;
                }

            }
        }

        public static class SecondSimCardID_6 extends SimBase.ImplementableBase {
            Method method;
            Object receiver;

            public SecondSimCardID_6(Method method, Object receiver) {
                super();
                this.method = method;
                this.receiver = receiver;
            }

            @Override
            protected String toStringInternal() {
                return getClass().getSimpleName();
            }

            @Override
            protected void getAllEntrieIMSI(Set<String> result) {
                Object object = null;
                for (int i = 0; i < 9; i++) {
                    try {
                        object = method.invoke(receiver, i);
                        if (object != null && !TextUtils.isEmpty(object.toString())) {
                            result.add(object.toString());
                        }
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e2) {
                    }
                }
            }


            public static class Builder extends SimBase.BaseBuilder {
                Method method = null;
                Object receiver = null;

                @Override
                protected boolean isSupportedReflectInternal(Context context) {
                    boolean ret = true;
                    receiver = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    Class<?> telephonyclass = receiver.getClass();
                    try {
                        method = telephonyclass.getDeclaredMethod("getSubscriberIdGemini", int.class);
                    } catch (NoSuchMethodException e) {
                        ret = false;
                    }

                    return ret;
                }

                public SecondSimCardID_6 build() {
                    return isSupported() ? new SecondSimCardID_6(method, receiver) : null;
                }

            }
        }
    }

}
