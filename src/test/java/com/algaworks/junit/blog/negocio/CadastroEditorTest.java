package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class CadastroEditorTest {

    private Editor editor;

    @Mock
    private ArmazenamentoEditor armazenamentoEditor;

    @Mock
    private GerenciadorEnvioEmail gerenciadorEnvioEmail;

    @InjectMocks
    private static CadastroEditor cadastroEditor;




    @BeforeEach
    void init() {
        editor = new Editor(1L, "Alex", "gggg@gmail.com", BigDecimal.TEN, true);
        when(armazenamentoEditor.salvar(Mockito.any(Editor.class)))
         .thenReturn(new Editor(1L, "Alex", "gggg@gmail.com", BigDecimal.TEN, true));
        /**
         * Customização do retorno do metodo
         */
//        when(armazenamentoEditor.salvar(any())).thenAnswer(invocacao -> {
//           Editor editorPassado = invocacao.getArgument(0, Editor.class);
//           editorPassado.setId(1L);
//           return editorPassado;
//        });
    }

    @Test
    void criarEditorTest() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());
    }



    @Test
    void verificarSeSalvarFoiChamadoTest(){
        cadastroEditor.criar(editor);
        Mockito.verify(armazenamentoEditor, Mockito.times(1)).salvar(Mockito.eq(editor));
    }


}