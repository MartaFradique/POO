package aula06.ex1;
import java.time.LocalDateTime;

public class Aluno extends Pessoa {
    private final Data DataInsc;
    private final int NMec;
    private static int count = 99;

    public Aluno(final String iNome, final int iBI, final Data iDataNasc, final Data iDataInsc) {
        super(iNome, iBI, iDataNasc);
        DataInsc = iDataInsc;
        count++;
        NMec = count;
    }

    public Aluno(final String iNome, final int iBI, final Data iDataNasc) {
        super(iNome, iBI, iDataNasc);
        count++;
        NMec = count;
        final LocalDateTime now = LocalDateTime.now();
        this.DataInsc=new Data(now.getDayOfMonth(),now.getMonthValue(),now.getYear());
    }

    int getNMec() {
        return NMec;
    }

    @Override
    public String toString() {
        return super.toString() + ", DataInsc=" + DataInsc + ", NMec=" + NMec;
    }

}