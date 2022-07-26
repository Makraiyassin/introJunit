package be.digitalcity.tu.revisionLambda;

@FunctionalInterface
public interface Deplacement<T> {
    void seDeplacer(T type);
}
