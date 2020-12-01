package _util;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static void printClassNameViaStackWalker(int skip) {
        String className = StackWalker.getInstance().walk(stream -> stream.skip(skip).findFirst()).get().getClassName();
        System.out.println(String.format("--- Class: %s ---", className));
        System.out.println();
    }

    public static void printMethodNameViaStackWalker(int skip) {
        String methodName = StackWalker.getInstance().walk(stream -> stream.skip(skip).findFirst()).get().getMethodName();
        System.out.println(String.format("--- %s() ---", methodName));
    }

    public static <T> void handleException(Supplier<T> s, String... optionalMsgs) {
        try {
            s.get();
        } catch (Throwable t) {
            System.err.println(t);
            if (optionalMsgs.length != 0) {

//                String joinedMsgs = Stream.of(optionalMsgs).map(i -> Optional.ofNullable(i)).filter(i -> !i.isEmpty()).map(Optional::get).collect(Collectors.joining(" | "));

                /*
                 * In Java,
                 *      - Optional is a MONAD!! Just as a Stream is a MONAD!!
                 *      - It has flatMap(); which will filter out the empty Optionals automatically
                 *      - Because Monads have the identity
                 *      - Optional.empty is the identity for the Optional Monad
                 */
                String joinedMsgs = Stream.of(optionalMsgs).map(i -> Optional.ofNullable(i)).flatMap(Optional::stream).collect(Collectors.joining(" | "));
                System.err.println(joinedMsgs);

                /*
                // notice the casting in "Optional.ofNullable((String) null)"
                Stream.of(Optional.ofNullable("aa"), Optional.ofNullable((String) null), Optional.ofNullable("bb"))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(
                        Collectors.joining(" | ")
                );

                 */
            }
        }
    }
}
