package com.cgi.mapper;

import org.springframework.stereotype.Component;

import com.cgi.model.Conta;
import com.cgi.model.Endereco;
import com.cgi.model.Telefone;
import com.cgi.model.Usuario;
import com.cgi.representation.ContaDTO;
import com.cgi.representation.EnderecoDTO;
import com.cgi.representation.TelefoneDTO;
import com.cgi.representation.UsuarioDTO;

@Component
public class UsuarioMapper {

    public UsuarioDTO convertToUsuarioDTO(Usuario usuario, Endereco endereco, Telefone telefone, Conta conta) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCriadoEm(usuario.getCriadoEm());
        usuarioDTO.setAlteradoEm(usuario.getAlteradoEm());
        usuarioDTO.setDeletadoEm(usuario.getDeletadoEm());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setSenha(usuario.getPassword());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setDocumento(usuario.getDocumento());

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setCriadoEm(endereco.getCriadoEm());
        enderecoDTO.setAlteradoEm(endereco.getAlteradoEm());
        enderecoDTO.setDeletadoEm(endereco.getDeletadoEm());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setPais(endereco.getPais());
        enderecoDTO.setUf(endereco.getUf());

        usuarioDTO.setEnderecoDTO(enderecoDTO);

        TelefoneDTO telefoneDTO = new TelefoneDTO();
        telefoneDTO.setCriadoEm(telefone.getCriadoEm());
        telefoneDTO.setAlteradoEm(telefone.getAlteradoEm());
        telefoneDTO.setDeletadoEm(telefone.getDeletadoEm());
        telefoneDTO.setNumero(telefone.getNumero());
        telefoneDTO.setRamal(telefone.getRamal());
        telefoneDTO.setTipo(telefone.getTipo());

        usuarioDTO.setTelefoneDTO(telefoneDTO);

        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setCriadoEm(conta.getCriadoEm());
        contaDTO.setAlteradoEm(conta.getAlteradoEm());
        contaDTO.setDeletadoEm(conta.getDeletadoEm());
        contaDTO.setTipoConta(conta.getTipoConta());
        contaDTO.setSaldo(conta.getSaldo());
        contaDTO.setId(conta.getId());

        usuarioDTO.setContaDTO(contaDTO);

        return usuarioDTO;
    }
}
