package br.com.proposta.proposta;

import br.com.proposta.proposta.documento.CpfGroup;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class PropostaSequenceProvider implements DefaultGroupSequenceProvider<PropostaRequest> {
    @Override
    public List<Class<?>> getValidationGroups(PropostaRequest propostaRequest) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(PropostaRequest.class);

        if(validar(propostaRequest)){
            groups.add(propostaRequest.getTipoPessoa().getGroup());
        }else{
            groups.add(CpfGroup.class);
        }

        return groups;
    }

    private boolean validar(PropostaRequest propostaRequest) {
        return propostaRequest != null && propostaRequest.getTipoPessoa() != null;
    }
}
