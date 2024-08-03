package com.cgi.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

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
import com.cgi.representation.validator.UsuarioDTOValidation;
import com.cgi.service.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private TelefoneRepository telefoneRepository;

    @Mock
    private ContaRepository contaRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock // As anotações mocks servem para criar objetos simulados para fins de testes
    private MailService mailService;

    @InjectMocks // Injeção do mock direto no service para ser usado nas classes de testes
    private UsuarioService usuarioService;

    // Aqui temos uma convenção usada em testes Junit aqui ela é usada para
    // inicializar todos os mocks antes da execução dos testes
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        UsuarioDTOValidation request = new UsuarioDTOValidation();

        // A função when é usada para alterar o comportamento da classes, no contexto
        // atual ele foi usado para chamar o respositórios afim de executar as funções
        // prédeterminadas do metodo
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(new Endereco());
        when(telefoneRepository.save(any(Telefone.class))).thenReturn(new Telefone());
        when(contaRepository.save(any(Conta.class))).thenReturn(new Conta());
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(new Usuario());

        usuarioService.save(request);

        // Por fim a função verify, como seu propŕio nome diz, ela verifica se o método
        // do mock foi chamado corretamante durante a cadeia de teste
        verify(mailService, times(1)).sendEmailCadastro(any(Usuario.class));
        verify(mailService, times(1)).sendJogoDoBicho(any(Usuario.class));
        verify(usuarioMapper, times(1)).convertToUsuarioDTO(any(Usuario.class), any(Endereco.class),
                any(Telefone.class), any(Conta.class));
    }

}
