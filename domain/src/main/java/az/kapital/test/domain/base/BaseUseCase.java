package az.kapital.test.domain.base;

public abstract class BaseUseCase<Result, Params> {

    protected abstract Result process(Params params);

    public Result execute(Params params) {
        return process(params);
    }

}
