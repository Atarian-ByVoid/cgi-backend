package com.cgi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.mail.MailService;
import com.cgi.mapper.UsuarioMapper;
import com.cgi.model.Conta;
import com.cgi.model.Endereco;
import com.cgi.model.Telefone;
import com.cgi.model.Usuario;
import com.cgi.repository.ContaRepository;
import com.cgi.repository.EnderecoRepository;
import com.cgi.repository.TelefoneRepository;
import com.cgi.repository.UsuarioRepository;
import com.cgi.representation.UsuarioDTO;
import com.cgi.representation.validator.UsuarioDTOValidation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private MailService mailService;

    @Transactional
    public UsuarioDTO save(UsuarioDTOValidation request) {

        Endereco endereco = new Endereco();
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCep(request.getEndereco().getCep());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setComplemento(request.getEndereco().getComplemento());
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        endereco.setPais(request.getEndereco().getPais());
        endereco.setUf(request.getEndereco().getUf());
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        // Mapear os dados do telefone
        Telefone telefone = new Telefone();
        telefone.setNumero(request.getTelefone().getNumero());
        telefone.setRamal(request.getTelefone().getRamal());
        telefone.setTipo(request.getTelefone().getTipo());
        Telefone telefoneSalvo = telefoneRepository.save(telefone);

        // Mapear os dados da conta
        Conta conta = new Conta();
        conta.setTipoConta(request.getConta().getTipoConta());
        Double saldo = 1350.123;
        conta.setSaldo(saldo);
        Conta contaSalva = contaRepository.save(conta);

        // Mapear os dados do usuário
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getSenha());
        usuario.setDocumento(request.getDocumento());
        usuario.encryptPassword();
        usuario.setEndereco(endereco);
        usuario.setTelefone(telefone);
        usuario.setConta(conta);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // this.mailService.sendEmailCadastro(usuarioSalvo);
        // this.mailService.sendJogoDoBicho(usuarioSalvo);

        return usuarioMapper.convertToUsuarioDTO(usuarioSalvo, enderecoSalvo, telefoneSalvo, contaSalva);
    }

}
