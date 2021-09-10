package az.kapital.test.domain.base;

public abstract class BaseUseCase<DTO, Result, Params> {

    protected abstract DTO process(Params params);

    protected abstract Result mapDTO(DTO data);

    public Result execute(Params params) {
        DTO data = process(params);
        return mapDTO(data);
    }

}
