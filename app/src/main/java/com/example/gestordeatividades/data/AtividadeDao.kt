package seu_pacote.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gestordeatividades.model.Atividade

@Dao
interface AtividadeDao {
    @Insert
    suspend fun inserir(atividade: Atividade)

    @Query("SELECT * FROM atividades ORDER BY id DESC")
    fun listarTodas(): LiveData<List<Atividade>>
}
